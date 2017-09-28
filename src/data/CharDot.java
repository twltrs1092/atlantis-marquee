package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * (Insert a brief comment that describes
 * the purpose of this class definition.)
 * <p>
 * <p/> Bugs: None known
 *
 * @author Team Atlantis
 */
public class CharDot implements Iterable<Dot[]>
{
    private static final HashMap<Character, int[][]> charMap = new HashMap<>(50);

    private String color;
    private Dot[][] charDots;
    private int length;

    public CharDot(char ch, String color)
    {
        this.color = color;
        int[][] leds = charMap.get(ch);
        System.out.println(ch);
        charDots = new Dot[leds.length][12];
        length = leds.length;

        for (int r = 0; r < leds.length; r++)
        {
            for (int c = 0; c < 12; c++)
            {
                if (leds[r][c] == 1)
                {
                    charDots[r][c] = new Dot(color, 100);
                }
                else
                {
                    charDots[r][c] = new Dot(color, 0);
                }
            }
        }
    }

    public CharDot()
    {
        charDots = new Dot[1][12];

        for (int i = 0; i < 12; i++)
        {
            color = "696969";
            length = 1;
            charDots[0][i] = new Dot(color, 0);
        }
    }

    public String getColor()
    {
        return color;
    }

    public Dot[][] getCharDots()
    {
        return charDots;
    }

    public int getLength()
    {
        return length;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public Iterator<Dot[]> iterator()
    {
        return new Iterator<>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length && charDots[index] != null;
            }

            @Override
            public Dot[] next() {
                return charDots[index++];
            }
        };
    }

    public static void initMap()
    {
        charMap.put('A', A);
        charMap.put('B', B);
        charMap.put('C', C);
        charMap.put('D', D);
        charMap.put('E', E);
        charMap.put('F', F);
        charMap.put('G', G);
        charMap.put('H', H);
        charMap.put('I', I);
        charMap.put('J', J);
        charMap.put('K', K);
        charMap.put('L', L);
        charMap.put('M', M);
        charMap.put('N', N);
        charMap.put('O', O);
        charMap.put('P', P);
        charMap.put('Q', Q);
        charMap.put('R', R);
        charMap.put('S', S);
        charMap.put('T', T);
        charMap.put('U', U);
        charMap.put('V', V);
        charMap.put('W', W);
        charMap.put('X', X);
        charMap.put('Y', Y);
        charMap.put('Z', Z);
        charMap.put('0', ZERO);
        charMap.put('1', ONE);
        charMap.put('2', TWO);
        charMap.put('3', THREE);
        charMap.put('4', FOUR);
        charMap.put('5', FIVE);
        charMap.put('6', SIX);
        charMap.put('7', SEVEN);
        charMap.put('8', EIGHT);
        charMap.put('9', NINE);
        charMap.put('!', EXCL);
        charMap.put('.', PERIOD);
        charMap.put(',', COMMA);
        charMap.put('$', DOLLAR);
        charMap.put('#', HASH);
        charMap.put('@', AT);
        charMap.put('&', AMP);
        charMap.put('*', ASTERISK);
        charMap.put('(', LEFTPAR);
        charMap.put(')', RIGHTPAR);
        charMap.put('+', PLUS);
        charMap.put('-', HYPHEN);
        charMap.put('/', SLASH);
        charMap.put(' ', SPACE);
    }

    private static final int[][] A = {{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                      {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                      {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    private static final int[][] B = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0}};

    private static final int[][] C = {{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0}};

    private static final int[][] D = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] E = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1}};

    private static final int[][] F = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                      {1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                      {1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    private static final int[][] G = {{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                                      {0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                                      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0}};

    private static final int[][] H = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                                      {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    private static final int[][] I = {{1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1}};

    private static final int[][] J = {{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                                      {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                                      {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                                      {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    // TODO: Continue here...

    private static final int[][] K = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] L = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] M = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] N = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] O = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] P = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] Q = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] R = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] S = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] T = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] U = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] V = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] W = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] X = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] Y = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] Z = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] ZERO = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] ONE = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] TWO = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] THREE = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] FOUR = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] FIVE = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] SIX = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] SEVEN = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] EIGHT = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] NINE = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] EXCL = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] PERIOD = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] COMMA = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] DOLLAR = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] HASH = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] AT = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] AMP = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] ASTERISK = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] LEFTPAR = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] RIGHTPAR = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] PLUS = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] HYPHEN = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] SLASH = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                      {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                      {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    private static final int[][] SPACE = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

/*    private static final Map<Character, int[][]> test = Map.of('A', A, 'B', B, 'C', C, 'D', D,
            'E', E, 'F', F, 'G', G, 'H', H, 'I', I, 'J', J, 'K', K, 'L', L, 'M', M, 'N', N, 'O', O,
            'P', P, 'Q', Q, 'R', R, 'S', S, 'T', T, 'U', U, 'V', V, 'W', W, 'X', X, 'Y', Y, 'Z', Z,
            '0', ZERO, '1', ONE, '2', TWO, '3', THREE, '4', FOUR, '5', FIVE, '6', SIX, '7', SEVEN,
            '8', EIGHT, '9', NINE, '!', EXCL, '.', PERIOD, ',', COMMA, '$', DOLLAR, '#', HASH, '@', AT,
            '&', AMP, '*', ASTERISK, '(', LEFTPAR, ')', RIGHTPAR, '+', PLUS, '-', HYPHEN, '/', SLASH, ' ', SPACE);*/
    }