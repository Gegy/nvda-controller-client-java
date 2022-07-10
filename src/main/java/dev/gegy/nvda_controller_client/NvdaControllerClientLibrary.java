package dev.gegy.nvda_controller_client;

import com.sun.jna.Library;
import com.sun.jna.Native;

interface NvdaControllerClientLibrary extends Library {
    static NvdaControllerClientLibrary load() {
        final Platform platform = Platform.get();

        final String path = getLibraryPath(platform);
        return Native.load(path, NvdaControllerClientLibrary.class);
    }

    private static String getLibraryPath(final Platform platform) {
        final String name = switch (platform.architecture()) {
            case X64 -> "x64/nvdaControllerClient64";
            case X86 -> "x86/nvdaControllerClient32";
            case ARM64 -> "arm64/nvdaControllerClient32";
            default -> throw new IllegalStateException("Unknown platform architecture: " + platform.architecture());
        };

        if (platform.operatingSystem() == Platform.OperatingSystem.WINDOWS) {
            return name + ".dll";
        } else {
            return name + ".lib";
        }
    }

    int nvdaController_brailleMessage(final char[] message);

    int nvdaController_cancelSpeech();

    int nvdaController_speakText(final char[] message);

    int nvdaController_testIfRunning();
}
