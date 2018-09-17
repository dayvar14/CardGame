package dev.aycoder.cardgame.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
    private static final int width = 48, height = 64;

    public static BufferedImage[][] cardImages;

    /*public static BufferedImage
            cardClubTwo, cardClubThree, cardClubFour, cardClubFive, cardClubSix, cardClubSeven, cardClubEight, cardClubNine, cardClubTen, cardClubJack, cardClubQueen, cardClubKing, cardClubAce,
            cardDiamondTwo, cardDiamondThree, cardDiamondFour, cardDiamondFive, cardDiamondSix, cardDiamondSeven, cardDiamondEight, cardDiamondNine, cardDiamondTen, cardDiamondJack, cardDiamondQueen, cardDiamondKing, cardDiamondAce,
            cardHeartTwo, cardHeartThree, cardHeartFour, cardHeartFive, cardHeartSix, cardHeartSeven, cardHeartEight, cardHeartNine, cardHeartTen, cardHeartJack, cardHeartQueen, cardHeartKing, cardHeartAce,
            cardSpadeTwo, cardSpadeThree, cardSpadeFour, cardSpadeFive, cardSpadeSix, cardSpadeSeven, cardSpadeEight, cardSpadeNine, cardSpadeTen, cardSpadeJack, cardSpadeQueen, cardSpadeKing, cardSpadeAce;
    */
    public static void init()
    {
        SpriteSheet sheet = new SpriteSheet( ImageLoader.loadImage("/textures/cards.png"));
        cardImages = new BufferedImage[4][13];

        for( int i = 0; i < cardImages.length; i++)
        {
            for( int j = 0; j< cardImages[i].length; j++)
            {
                int x = j * 48;
                int y = i * 64;
                cardImages[i][j] = sheet.crop(x, y, width, height);
            }
        }
    }
}
