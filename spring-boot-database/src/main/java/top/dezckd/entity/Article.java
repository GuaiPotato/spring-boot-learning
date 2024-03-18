package top.dezckd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DEZ
 * @DATE 2024/3/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // [ 必选 ]
@Table(name="t_article") // [ 可选 ] => 表名 与 类名满足 转大驼峰格式 则不需要
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 32)
    private String author;

    @Column(nullable = false, length = 32)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;
}
