package net.velocityHelper.common;

import net.velocityHelper.servers.MinecraftServer;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Network {
    private final Path mainFolder;
    private final String velocityFolderName;

    private static final List<MinecraftServer> servers = new LinkedList<>();

    public Network(Path mainFolder, String velocityFolderName) {
        this.mainFolder = mainFolder;
        this.velocityFolderName = velocityFolderName;
    }

}
