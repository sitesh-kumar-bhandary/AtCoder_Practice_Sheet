package ABC_400;
import java.io.*;

public class ChocolateBar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int h = Integer.parseInt(exp[0]);
        int w = Integer.parseInt(exp[1]);

        long result1 = chocolateBar(h, w);
        long result2 = chocolateBar(w, h);
        System.out.println(Math.min(result1, result2));
        br.close();
    }

    private static long chocolateBar(int h, int w){
        // Case I - First try to cut a height by 3, if it is divisible 
        // then both heights comes to same but it's not divisible then we have two conditions h, h+1
        int reqHeight1 = h / 3;
        long currArea1 = findCurrArea(reqHeight1, h, w);

        int reqHeight2 = reqHeight1 + 1;
        long currArea2 = findCurrArea(reqHeight2, h, w);

        return Math.min(currArea1, currArea2);
    }

    private static long findMinDiff(long area1, long area2, long area3){
        long maxArea = Math.max(area1, Math.max(area2, area3));
        long minArea = Math.min(area1, Math.min(area2, area3));

        return maxArea - minArea;
    }

    private static long findCurrArea(int firstHeight, int h, int w){
        long minDiff = Long.MAX_VALUE;
        long area1 = firstHeight * w;

        // I - Cut remaining rectange in halves by height
        int remHeight1 = (h - firstHeight)/2;
        int area2 = remHeight1 * w;

        int remHeight2 = h - firstHeight - remHeight1;
        int area3 = remHeight2 * w;

        long currMinDiff1 = findMinDiff(area1, area2, area3);
        minDiff = Math.min(minDiff, currMinDiff1);

        long currMinDiff2 = findMinDiffCutByWidth(h-firstHeight, w, area1);
        minDiff = Math.min(minDiff, currMinDiff2);

        return minDiff;
    }

    private static long findMinDiffCutByWidth(int h, int w, long area1){
        int half = w / 2;
        long area2 = half * h;
        long area3 = (w - half) * h;

        long currMinDiff = findMinDiff(area1, area2, area3);
        return currMinDiff;
    }
}