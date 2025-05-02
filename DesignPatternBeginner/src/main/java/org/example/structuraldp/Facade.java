package org.example.structuraldp;

import org.example.structuraldp.facade.MultimediaFacade;

public class Facade {
    public static void main(String[] args) {
        MultimediaFacade multimediaFacade = new MultimediaFacade();

        multimediaFacade.playMedia("song.mp3", "audio");
        multimediaFacade.playMedia("movie.mp4", "video");
        multimediaFacade.playMedia("photo.jpg", "image");
        multimediaFacade.playMedia("document.pdf", "pdf");  // Unsupported media type
    }
}
