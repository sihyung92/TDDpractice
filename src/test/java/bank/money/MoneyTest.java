package bank.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("돈 생성 테스트")
    @Test
    void 돈_생성_테스트() {
        //given
        Money money = new Money(1000L);
        //when & then
        assertThat(Objects.isNull(money)).isFalse();
    }

    @DisplayName("액수를 확인한다.")
    @ParameterizedTest
    @CsvSource({"1000,1000", "2000,2000", "5000,5000"})
    void 액수를_확인한다(long amount, long expectedResult) {
        //given && when
        Money money = new Money(amount);

        //then
        assertThat(money.amount()).isEqualTo(expectedResult);
    }

    @DisplayName("돈을 추가한다.")
    @ParameterizedTest
    @CsvSource({"1000,1000", "2000,2000", "30000000,30000000"})
    void 돈을_추가한다(long addAmount, long expectedResult) {
        //given
        Money money = new Money(0L);

        //when
        Money result = money.plusMoney(addAmount);

        //then
        assertThat(result.amount()).isEqualTo(expectedResult);
    }

    @DisplayName("돈을 뺀다")
    @ParameterizedTest
    @CsvSource(value = {"5000:5000", "10000:0", "5500:4500"}, delimiter = ':')
    void 돈을_뺀다(long minusAmount, long expectedResult) {
        //given
        Money money = new Money(10000L);

        //when
        Money result = money.minusMoney(minusAmount);

        //then
        assertThat(result.amount()).isEqualTo(expectedResult);
    }

    @DisplayName("0원보다 작으면 에러가 나는지 확인한다")
    @Test
    void 돈은_양수인지_확인한다() {
        //given
        Money money = new Money(1000L);

        //when & then
        assertThatThrownBy(() -> money.minusMoney(5000L))
                .isInstanceOf(IllegalArgumentException.class);
    }
}