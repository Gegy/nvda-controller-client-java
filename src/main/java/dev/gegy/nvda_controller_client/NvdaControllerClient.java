package dev.gegy.nvda_controller_client;

public final class NvdaControllerClient {
    private final NvdaControllerClientLibrary library;

    private NvdaControllerClient(final NvdaControllerClientLibrary library) {
        this.library = library;
    }

    public static NvdaControllerClient create() {
        return new NvdaControllerClient(NvdaControllerClientLibrary.load());
    }

    public void speak(final String message) {
        library.nvdaController_speakText(encodeString(message));
    }

    public void braille(final String message) {
        library.nvdaController_brailleMessage(encodeString(message));
    }

    public void cancel() {
        library.nvdaController_cancelSpeech();
    }

    public boolean isRunning() {
        return library.nvdaController_testIfRunning() == 0;
    }

    private static char[] encodeString(final String message) {
        final char[] chars = message.toCharArray();
        final char[] terminated = new char[chars.length + 1];
        System.arraycopy(chars, 0, terminated, 0, chars.length);
        return terminated;
    }
}
