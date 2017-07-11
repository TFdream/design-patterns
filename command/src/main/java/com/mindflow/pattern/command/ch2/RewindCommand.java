package com.mindflow.pattern.command.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 14:42
 */
public class RewindCommand implements Command {
    private AudioPlayer audioPlayer;

    public RewindCommand(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;
    }
    
    @Override
    public void execute() {
        this.audioPlayer.rewind();
    }
}
