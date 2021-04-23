import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringTest {

    @Test
    @Order(1)
    @DisplayName("요구사항1 - String.split() ")
    void testSplit() {
        String oneTwo = "1,2";
        String one = "1";

        String[] oneTwoArr = {"1", "2"};
        String[] oneArr = {"1"};

        assertThat(oneTwo.split(",")).contains("1").contains("2").containsExactly(oneTwoArr);
        assertThat(one.split("")).contains("1").containsExactly(oneArr);
    }

    @Test
    @Order(2)
    @DisplayName("요구사항2 - String.substring() ")
    void testSubstring() {
        String oneTwoWithRoundBracket = "(1,2)";

        String oneTwo = "1,2";

        assertThat(oneTwoWithRoundBracket.substring(
                oneTwoWithRoundBracket.indexOf("(") + 1,
                oneTwoWithRoundBracket.lastIndexOf(")")
        )).isEqualTo(oneTwo);
    }

    @Test
    @Order(3)
    @DisplayName("요구사항3 - String.charAt() ")
    void testCharAt() {
        String abc = "abc";

        char a = 'a';
        char b = 'b';
        char c = 'c';

        assertThat(abc.charAt(0)).isEqualTo(a);
        assertThat(abc.charAt(1)).isEqualTo(b);
        assertThat(abc.charAt(2)).isEqualTo(c);
    }

    @Test
    @Order(4)
    @DisplayName("요구사항3 - String.charAt() - assertThatThrownBy - IndexOutOfBoundsException")
    void testCharAtWithIndexOutOfBoundsException1() {
        String abc = "abc";

        char a = 'a';
        char b = 'b';
        char c = 'c';

        assertThatThrownBy(() -> abc.charAt(-1))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");

        assertThatThrownBy(() -> abc.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    @Test
    @Order(5)
    @DisplayName("요구사항3 - String.charAt() - assertThatExceptionOfType - IndexOutOfBoundsException")
    void testCharAtWithIndexOutOfBoundsException2() {
        String abc = "abc";

        char a = 'a';
        char b = 'b';
        char c = 'c';

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> abc.charAt(300))
                .withMessageMatching("String index out of range: [\\-]?\\d+");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> abc.charAt(-100))
                .withMessageMatching("String index out of range: [\\-]?\\d+");
    }
}
