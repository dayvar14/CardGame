package dev.aycoder.cardgame.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
    private static final int width = 16, height = 16;

    public static BufferedImage[][] cardImages;
    public static BufferedImage[] characterImages;

    /*public static BufferedImage
            cardClubTwo, cardClubThree, cardClubFour, cardClubFive, cardClubSix, cardClubSeven, cardClubEight, cardClubNine, cardClubTen, cardClubJack, cardClubQueen, cardClubKing, cardClubAce,
            cardDiamondTwo, cardDiamondThree, cardDiamondFour, cardDiamondFive, cardDiamondSix, cardDiamondSeven, cardDiamondEight, cardDiamondNine, cardDiamondTen, cardDiamondJack, cardDiamondQueen, cardDiamondKing, cardDiamondAce,
            cardHeartTwo, cardHeartThree, cardHeartFour, cardHeartFive, cardHeartSix, cardHeartSeven, cardHeartEight, cardHeartNine, cardHeartTen, cardHeartJack, cardHeartQueen, cardHeartKing, cardHeartAce,
            cardSpadeTwo, cardSpadeThree, cardSpadeFour, cardSpadeFive, cardSpadeSix, cardSpadeSeven, cardSpadeEight, cardSpadeNine, cardSpadeTen, cardSpadeJack, cardSpadeQueen, cardSpadeKing, cardSpadeAce;
    */
    public static void init()
    {
        SpriteSheet sheet = new SpriteSheet( ImageLoader.loadImage("/textures/sheet.png"));

        //Array of Card Images
        cardImages = new BufferedImage[4][13];
        int cardHeight = height * 4;
        int cardWidth = width * 3;
        for( int i = 0; i < cardImages.length; i++)
        {
            for( int j = 0; j< cardImages[i].length; j++)
            {
                int x = j * cardWidth;
                int y = i * cardHeight;
                cardImages[i][j] = sheet.crop(x, y, cardWidth, cardHeight);
            }
        }

        //Array of Character Images
        characterImages = new BufferedImage[4];

        int characterHeight = height * 3;
        int characterWidth = width * 3;
        for( int i = 0; i < characterImages.length; i++)
        {
            int x = i * characterWidth;
            int y = 256;
            characterImages[i] = sheet.crop(x, y, characterWidth, characterHeight);
        }
    }
}
