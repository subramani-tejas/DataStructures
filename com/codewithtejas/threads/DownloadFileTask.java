package com.codewithtejas.threads;

public class DownloadFileTask implements Runnable {
    private DownloadStatus status;

    public DownloadFileTask() {
        this.status = new DownloadStatus();
    }

    @Override
    public void run() {
        System.out.println("Downloading a file..." + Thread.currentThread().getName());

        /*// simulate a long running task
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // long-running task
        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            // System.out.println("Downloading byte " + i);
            status.incrementTotalBytes();
        }

        System.out.println("Download complete! " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
