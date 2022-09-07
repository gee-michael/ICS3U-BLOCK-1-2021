package week16;

import java.util.Scanner;

public class NameGen2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] words = {
            "aka 赤",
            "aki 秋",
            "ao 青",
            "asa 浅",
            "awa 淡",
            "aya 綾",
            "bukuro 袋",
            "e 江",
            "fuku 福",
            "fune 船",
            "hama 浜",
            "hana 花",
            "hara 原",
            "hashi 橋",
            "hasu 蓮",
            "hikari 光",
            "higashi 東",
            "hinoki 檜",
            "hiro 広",
            "i 井",
            "ibara 茨",
            "ike 池",
            "ishi 石",
            "ita 板",
            "iwa 岩",
            "ina 稲",
            "kaba 樺",
            "kami 神",
            "kane 金",
            "kashiwa 柏",
            "kasumi 霞",
            "kawa 川",
            "ki 木",
            "kita 北",
            "kubo 窪",
            "kuchi 口",
            "kuma 熊",
            "kura 庫",
            "kuro 黒",
            "kurogane 鉄",
            "kusa 草",
            "kuzu 葛",
            "machi 町",
            "masu 増",
            "matsu 松",
            "michi 道",
            "minami 南",
            "minato 港",
            "miya 宮",
            "miyako 京",
            "mizu 水",
            "mori 森",
            "moto 本",
            "mura 村",
            "muro 室",
            "ne 目",
            "naka 中",
            "nari 成",
            "nashi 梨",
            "ne 根",
            "nii 新",
            "nishi 西",
            "no 野",
            "nochi 後",
            "oo 大",
            "o 尾",
            "oka 岡",
            "oki 沖",
            "ogi 荻",
            "saka 阪",
            "saki 崎",
            "sawa 沢",
            "se 瀬",
            "shika 鹿",
            "shima 島",
            "shina 品",
            "shiro 城",
            "shizu 静",
            "sugi 杉",
            "ta 田",
            "taka 高",
            "take 竹",
            "tama 玉",
            "tani 谷",
            "tera 寺",
            "to 戸",
            "tochi 栃",
            "toku 徳",
            "tora 虎",
            "tori 鳥",
            "tsu 津",
            "tsuka 塚",
            "tsuke 附",
            "tsuru 鶴",
            "ume 梅",
            "umi 海",
            "uta 歌",
            "ya 屋",
            "yama 山",
            "yawa 和",
            "yoshi 吉"
        };

        System.out.println("How many names would you like to generate?");
        String strNum = in.nextLine().toUpperCase();
        int intNum = Integer.parseInt(strNum);
        String result = "";

        for (int i = 0; i < intNum; i++){
            int length = (int) (Math.random() * 1.5 + 2);
            String name = "";
            for (int j = 0; j < length; j++){
                int index = (int) (Math.random() * (words.length + 1) - 1);
                name += words[index].substring(0, words[index].indexOf(" "));
            }
            result += name + "\n";
        }
        System.out.println(result);
        in.close();
    }
}
