package common;

import lombok.Data;

/**
   @FileName  : DongArr.java
   @Description : 중복동 처리를 위한 공유 변수
   @author      : KMS
   @since       : 2017. 11. 16.
   @version     : 1.0

   @개정이력

   수정일          수정자         수정내용
   -----------     ---------      -------------------------------
   2017. 11. 16.    KMS            최초생성

 */
@Data
public class ShareVal {

    /** 중복동 처리용 공유 배열 변수 */
    public static String[] dongArr;

}
