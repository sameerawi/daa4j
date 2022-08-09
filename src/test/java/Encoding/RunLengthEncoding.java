package Encoding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//  String Compression / run length encoding - leetcode 443

// [aab][bcc][ccc][ddd][ddd][e]

public class RunLengthEncoding extends Thread
{
    public static List<RunLengthEncoding> threads = new ArrayList<>();
    public static char [] data;
    public int start;
    public int end;
    StringBuilder encoded = new StringBuilder();

    public RunLengthEncoding()
    {

    }

    public RunLengthEncoding(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    public void run()
    {
        char lastChar = data[start];
        encoded.append(lastChar);
        int count = 1;

        for (int i = start+1; i <= end; i++)
        {
            if ( lastChar != data[i])
            {
                encoded.append(count > 1 ? String.valueOf(count) : "");
                encoded.append(data[i]);
                lastChar = data[i];
                count = 1;
            }

            count++;
        }

        encoded.append(count > 1 ? String.valueOf(count) : "");
    }

    public static void fork(char [] data, int noOfThreads)
    {
        RunLengthEncoding.data = data;

        if (data.length > noOfThreads)
        {
            int charsPerThead = data.length / noOfThreads;

            int start = 0;
// [aa][bb][cc]c
            while (start <= data.length-1)
            {
                if ( start+charsPerThead-1 < data.length)
                    threads.add(new RunLengthEncoding(start, start+charsPerThead-1));
                else
                    threads.add(new RunLengthEncoding(start, data.length-1));

                start += charsPerThead;
            }

            threads.forEach(t -> t.run());
        }
    }

    public String _join() throws InterruptedException
    {
        StringBuilder mergedStr = new StringBuilder();

        RunLengthEncoding lt = threads.get(0), rt = null;
        lt.join();
        String lStr = lt.encoded.toString();
        mergedStr.append(lStr);

        for (int i = 1; i < threads.size(); i++)
        {
            rt = threads.get(i);
            rt.join();

            //lStr = lt.encoded.toString();
            String rStr = rt.encoded.toString();

//            if (lStr.charAt(lStr.length()-1) == rStr.charAt(0))
//            {
//                mergedStr.append(lStr.substring(0, lStr.length()-2));
//
//            }

            //mergedStr.append(lStr);
            mergedStr.append(rStr);

            lt = rt;
        }

        return mergedStr.toString();
    }

    public String encode(char [] data, int start, int end )
    {
//        if (end-start<2)
//            return new String(data[start]);

        StringBuilder builder = new StringBuilder();

        int count = 0;

        for (int i = start; i < data.length; i++)
        {
            count++;

            if (i == data.length - 1 && data[i] == data[i - 1])
            {
                builder.append(data[i] + String.valueOf(count));
            } else if (i == data.length - 1 && data[i] != data[i - 1])
            {
                builder.append(data[i]);
            } else if (data[i] != data[i + 1])
            {
                builder.append(data[i] + String.valueOf(count > 1 ? count : ""));
                count = 0;
            }
        }

        return builder.toString();
    }

    public String encode_MT(char [] data, int noOfThreads)
    {
        fork(data, noOfThreads);
        try
        {
            return _join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return "";
    }

    public String encode(char [] data)
    {
        if (data.length<2)
            return new String(data);

        StringBuilder builder = new StringBuilder();

        int count = 0;

        for (int i=0; i<data.length; i++)
        {
            count++;

            if ( i == data.length-1 && data[i] == data[i-1] )
            {
                builder.append(data[i] + String.valueOf(count));
            }
            else if ( i == data.length-1 && data[i] != data[i-1] )
            {
                builder.append(data[i]);
            }
            else if (data[i] != data[i+1])
            {
                builder.append(data[i] + String.valueOf(count>1 ? count : ""));
                count = 0;
            }
        }

        return builder.toString();
    }


}

