import dev.aycoder.game.gfx.Assets;
import dev.aycoder.game.gfx.ImageLoader;
import dev.aycoder.game.gfx.SpriteSheet;

import java.awt.image.BufferedImage;

public class CardAssets extends Assets
{
    private static final int width = 16, height = 16;

    public static BufferedImage[][] cardImages;
    public static BufferedImage[] characterImages, buttonImages;
    public static BufferedImage player;


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
        characterImages = new BufferedImage[1];

        int characterHeight = height * 3;
        int characterWidth = width * 3;
        for( int i = 0; i < characterImages.length; i++)
        {
            int x = i * characterWidth;
            int y = 256;
            characterImages[i] = sheet.crop(x, y, characterWidth, characterHeight);
        }

        //Array of Buttons
        buttonImages = new BufferedImage[1];
        int buttonHeight = height * 2;
        int buttonWidth = width * 7;

        for( int i = 0; i < buttonImages.length; i++)
        {
            int x = i * buttonWidth;
            int y = 304;
            buttonImages[i] = sheet.crop(x, y, buttonWidth, buttonHeight);
        }

        //Player

        player = sheet.crop( 0, 256, height*3, height*3);
    }
}

