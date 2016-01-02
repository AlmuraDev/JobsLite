package me.Flibio.JobsLite.Listeners;

import me.Flibio.JobsLite.JobsLite;
import me.Flibio.JobsLite.Utils.HttpUtils;
import me.Flibio.JobsLite.Utils.JsonUtils;
import me.Flibio.JobsLite.Utils.PlayerManager;
import me.Flibio.JobsLite.Utils.TextUtils;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;

public class PlayerJoinListener {
	
	private PlayerManager playerManager = JobsLite.access.playerManager;
	private HttpUtils httpUtils = new HttpUtils();
	
	@Listener
	public void onPlayerJoin(ClientConnectionEvent.Join event) {
		playerManager.addPlayer(event.getTargetEntity().getUniqueId().toString());
		Player player = event.getTargetEntity();
		JobsLite.access.economyService.createAccount(player.getUniqueId());
		JobsLite.access.game.getScheduler().createTaskBuilder().execute(new Runnable() {
			public void run() {
				if(player.hasPermission("jobs.admin.updates")&&JobsLite.optionEnabled("updateNotifications")) {
					JsonUtils jsonUtils = new JsonUtils();
					TextUtils textUtils = new TextUtils();
					//Get the data
					String latest = httpUtils.requestData("https://api.github.com/repos/Flibio/JobsLite/releases/latest");
					if(latest.isEmpty()) return;
					String version = jsonUtils.getVersion(latest).replace("v", "");
					String changes = httpUtils.requestData("https://flibio.github.io/JobsLite/changelogs/"+version.replaceAll("\\.", "-")+".txt");
					String[] iChanges = changes.split(";");
					String url = jsonUtils.getUrl(latest);
					boolean prerelease = jsonUtils.isPreRelease(latest);
					//Make sure the latest update is not a prerelease
					if(!prerelease) {
						//Check if the latest update is newer than the current one
						String currentVersion = JobsLite.access.version;
						if(jsonUtils.versionCompare(version, currentVersion)>0) {
							player.sendMessage(textUtils.updateAvailable(version, url));
							for(String change : iChanges) {
								if(!change.trim().isEmpty()) {
									player.sendMessage(textUtils.change(change));
								}
							}
						}
					}
				}
			}
		}).async().submit(JobsLite.access);
	}
}
