package dev.stardust;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import dev.stardust.util.MsgUtil;
import dev.stardust.util.StardustUtil;
import dev.stardust.modules.AxolotlTools;
import net.fabricmc.loader.api.FabricLoader;
import meteordevelopment.meteorclient.MeteorClient;
import net.fabricmc.loader.api.metadata.CustomValue;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.Category;

/**
 * @author Tas [0xTas] <root@0xTas.dev>
 **/
public class Stardust extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Stardust", StardustUtil.chooseMenuIcon());

    @Override
    public void onInitialize() {
        Modules.get().add(new AxolotlTools());

        MsgUtil.initModulePrefixes();
        LOG.info("<✨> Stardust initialized.");
    }

    @Override
    public String getPackage() {
        return "dev.stardust";
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(Stardust.CATEGORY);
    }

    @Override
    public String getWebsite() { return "https://github.com/0xTas/stardust"; }

    @Override
    public GithubRepo getRepo() { return new GithubRepo("0xTas", "Stardust", "main", null); }

    @Override
    public String getCommit() {
        CustomValue commit = FabricLoader.getInstance()
            .getModContainer("stardust")
            .orElseThrow()
            .getMetadata()
            .getCustomValue(MeteorClient.MOD_ID + ":commit");

        return commit == null ? null : commit.getAsString();
    }
}
