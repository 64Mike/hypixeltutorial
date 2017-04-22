package me.bluesnapple.api;

import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.PlayerReply;
import net.hypixel.api.request.Request;
import net.hypixel.api.request.RequestBuilder;
import net.hypixel.api.request.RequestParam;
import net.hypixel.api.request.RequestType;
import net.hypixel.api.util.Callback;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GetPlayer{

    public static void main(Player player) {
        HypixelAPI.getInstance().setApiKey(Util.API_KEY);

        Request request = RequestBuilder.newBuilder(RequestType.PLAYER)
                .addParam(RequestParam.PLAYER_BY_UUID, UUID.fromString("b4e349c7-eb0b-4860-95fa-c0c808191343"))
                .createRequest();
        HypixelAPI.getInstance().getAsync(request, (Callback<PlayerReply>) (failCause, result) -> {
            if (failCause != null) {
                failCause.printStackTrace();
            } else {
                player.sendMessage(result.getPlayer().get("displayname").getAsString());
            }
            HypixelAPI.getInstance().finish();
        });
    }

}
