package editor;

import java.io.File;

public abstract class FileChangedListener {
    public abstract void fileChanged(File file, FileChangeType type);
}
