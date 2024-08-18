package ru.itexus.main.Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {
    private boolean append;
    private boolean initialized;
    private DataOutputStream dos;

    protected MyObjectOutputStream(boolean append) throws IOException, SecurityException {
        super();
        this.append = append;
        this.initialized = true;
    }

    public MyObjectOutputStream(OutputStream out, boolean append) throws IOException {
        super(out);
        this.append = append;
        this.initialized = true;
        this.dos = new DataOutputStream(out);
        this.writeStreamHeader();
    }

    /**
     * The standard ObjectOutputStream class initially writes a header to the file,
     * which may later cause an error when reading the created file,
     * which indicates that 1 more header is not expected in the file. That's why I'm redefining it.
     */

    @Override
    protected void writeStreamHeader() throws IOException {
        if (!this.initialized || this.append) return;
        if (dos != null) {
            dos.writeShort(STREAM_MAGIC);
            dos.writeShort(STREAM_VERSION);
        }
    }
}
