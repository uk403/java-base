package com.ukyu;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * @author ukyu
 * @date 2021/1/20
 **/
public class LoveTina {
    public static void main(String[] args) {
        //C 0
        //D 1
        //E 2
        //F 3
        //G 4
        //A 5
        //B 6
        //C 7
        //  5 1 2 0 3 1 2 2 3 1 2 2 3 1 2 2 2 2 2 2 7 7 1 6
        Player player = new Player();
//        player.play("A D E C F D E E F D E E F D E E E E E E C C D B");
        player.play("RW RW");
//        Player player = new Player();
//        Pattern doubleMeasureRest = new Pattern("Rw Rw");
//        //兩隻老虎 do re mi do
//        Pattern pattern1 = new Pattern("C5q D5q E5q C5q");
//
//        //跑得快 mi fa so
//        Pattern pattern2 = new Pattern("E5q F5q G5h");
//
//        //一隻沒有尾巴(一隻沒有耳朵) so la so fa mi do
//        Pattern pattern3 = new Pattern("G5i A5i G5i F5i E5q C5q");
//
//        //真奇怪 do so do
//        Pattern pattern4 = new Pattern("C5q G4q C5h");
//
//        //將所有的急速拍打聲集合起來形成歌
//        Pattern song = new Pattern();
//        song.add(pattern1, 2); // "兩隻老虎" 重複播放兩遍
//        song.add(pattern2, 2); // "跑得快" 重複播放兩遍
//        song.add(pattern3, 2); // 一隻沒有尾巴(一隻沒有耳朵)
//        song.add(pattern4, 2); // "真奇怪" 重複播放兩遍
//
//
//
//        //建立第一個聲音
//        Pattern round1 = new Pattern("V0");
//        round1.add(song);
//
//        ////建立第二個聲音
//        Pattern round2 = new Pattern("V1");
//        round2.add(doubleMeasureRest);
//        round2.add(song);
//
//        //建立第三個聲音
//        Pattern round3 = new Pattern("V2");
//        round3.add(doubleMeasureRest, 2);
//        round3.add(song);
//
//        // 把聲音一起放入roundSong
//        Pattern roundSong = new Pattern();
//        roundSong.add(round1);
//        roundSong.add(round2);
//        roundSong.add(round3);
//
//        //播放歌曲
//        player.play(roundSong);
    }
}
