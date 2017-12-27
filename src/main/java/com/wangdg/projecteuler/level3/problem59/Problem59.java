package com.wangdg.projecteuler.level3.problem59;

import org.apache.commons.collections4.iterators.PermutationIterator;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://projecteuler.net/problem=59
 */
public class Problem59 {

    public static void main(String[] args) throws IOException {

        byte[] cipherBytes = getBytes();

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[] strArray = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            strArray[i] = "" + chars[i];
        }
        Iterator<int[]> iterator = CombinatoricsUtils.combinationsIterator(strArray.length, 3);
        while (iterator.hasNext()) {
            int[] combine = iterator.next();
            List<String> coll = new ArrayList<>();
            for (int v : combine) {
                coll.add(strArray[v]);
            }
            PermutationIterator<String> permutationIterator = new PermutationIterator<>(coll);
            while (permutationIterator.hasNext()) {
                String key = permutationIterator.next().stream()
                        .reduce("", (a, s) -> a + s);
                byte[] bytes = decrypt(cipherBytes, key);
                String content = new String(bytes);
                if (StringUtils.contains(content, " the ")) {

                    // 明文
                    System.out.println("decryption: " + content);

                    // 计算加和
                    int sum = 0;
                    for (byte b : bytes) {
                        sum += b;
                    }
                    System.out.println("result = " + sum);
                    return;
                }
            }
        }
    }

    private static byte[] getBytes() throws IOException {
        String fileContent = IOUtils.toString(Problem59.class.getResourceAsStream("/problem59.txt"), "UTF-8");
        fileContent = StringUtils.trim(fileContent);
        String[] strArray = fileContent.split(",");
        byte[] bytes = new byte[strArray.length];
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            bytes[i] = Byte.parseByte(strArray[i]);
        }
        return bytes;
    }

    private static byte[] decrypt(byte[] bytes, String key) throws UnsupportedEncodingException {
        byte[] keyBytes = key.getBytes("UTF-8");
        byte[] decryptBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            decryptBytes[i] = keyBytes[i % keyBytes.length];
        }

        byte[] result = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = (byte) (bytes[i] ^ decryptBytes[i]);
        }

        return result;
    }
}
