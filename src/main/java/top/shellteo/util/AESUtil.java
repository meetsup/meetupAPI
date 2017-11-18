package top.shellteo.util;

import com.aliyun.oss.common.utils.LogUtils;
import org.apache.commons.logging.Log;
import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.UUID;

/** sha1算法
 * Created by HP on 2017/10/13.
 */
public class AESUtil {
    public static final AESUtil instance = new AESUtil();
    public static boolean initialized = false;
    //sha1加密
    public static String getSha1(String str) throws Exception{
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 解密
     * 用法:Base64.decodeBase64(encryptedData), Base64.decodeBase64(session_key), Base64.decodeBase64(iv)
     * @param content 解密内容
     * @param keyByte
     * @param ivByte
     * @return
     * @throws InvalidAlgorithmParameterException
     */
    public byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte) throws Exception {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));// 初始化
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw e;
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            throw e;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw e;
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            throw e;
        } catch (BadPaddingException e) {
            e.printStackTrace();
            throw e;
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void initialize(){
        if (initialized) return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }
    //生成iv
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception{
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }

    public static void main(String[] args) {
        try{
            String s1 = "fb2c5dc606b5b1cfc07f72a0c2add6ff61c932ad";
            String res = AESUtil.getSha1("{\"nickName\":\"tlhagh\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"\",\"province\":\"Shanghai\",\"country\":\"China\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLYoXpoN7jLzMibubEP0goWm2YUibia0DpKyPFCM9gBiciacPr5ibwC0WicKEM0BIsnFBWuyyvlGY0gHG88g/0\"}7/Aa7rQ9fkTmaPhWC8Eocw==");
            if (res.equals(s1)){
                System.out.println("OK");
            }


            String res2 = AESUtil.getSha1("{\"nickName\":\"Band\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"Guangzhou\",\"province\":\"Guangdong\",\"country\":\"CN\",\"avatarUrl\":\"http://wx.qlogo.cn/mmopen/vi_32/1vZvI39NWFQ9XM4LtQpFrQJ1xlgZxx3w7bQxKARol6503Iuswjjn6nIGBiaycAjAtpujxyzYsrztuuICqIM5ibXQ/0\"}HyVFkGl5F5OQWJZZaNzBBg==");
            if (res2.equals("75e81ceda165f4ffa64f4068af58c64b8f54b88c")){
                System.out.println("OK");
            }
            System.out.println(res);
        }catch (Exception e){

        }

    }
}
