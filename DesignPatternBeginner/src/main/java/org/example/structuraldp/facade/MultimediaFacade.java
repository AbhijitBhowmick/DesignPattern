package org.example.structuraldp.facade;

// Facade Class
public class MultimediaFacade {
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;
    private ImageLoader imageLoader;

    public MultimediaFacade() {
        this.audioPlayer = new AudioPlayer();
        this.videoPlayer = new VideoPlayer();
        this.imageLoader = new ImageLoader();
    }

    public void playMedia(String filename, String mediaType) {
        switch (mediaType.toLowerCase()) {
            case "audio":
                audioPlayer.playAudio(filename);
                break;
            case "video":
                videoPlayer.playVideo(filename);
                break;
            case "image":
                imageLoader.loadImage(filename);
                break;
            default:
                System.out.println("Unsupported media type: " + mediaType);
        }
    }
}

