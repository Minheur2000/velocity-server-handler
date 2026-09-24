package net.velocityHelper.common;

import net.minheur.potoflux.utils.Json;
import net.velocityHelper.VelocityHelper;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConfigHandler {
    public static final Path SAVED_NETWORK_PATH = VelocityHelper.getModDir().resolve("networks");

    private static @NotNull List<Path> getNetworksPathList() {
        List<Path> networksPaths = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(SAVED_NETWORK_PATH)) {
            paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".json"))
                    .forEach(networksPaths::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return networksPaths;
    }

    private static Network extract(Path networkPath) throws IOException {
        String content = Files.readString(networkPath);
        return Json.GSON.fromJson(content, Network.class);
    }

    public static @NotNull List<Network> getNetworks() {
        List<Path> networkPaths = getNetworksPathList();
        List<Network> networks = new ArrayList<>();

        for (Path path : networkPaths) try {
            networks.add(extract(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return networks;
    }
}
