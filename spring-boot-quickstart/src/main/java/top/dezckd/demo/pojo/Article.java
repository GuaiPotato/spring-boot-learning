package top.dezckd.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author DEZ
 * @DATE 2024/2/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {

    private Long id;

    private String author;

    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private List<Reader> readerList;
}
