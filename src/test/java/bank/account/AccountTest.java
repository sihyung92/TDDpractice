package bank.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
    @DisplayName("은행계좌 생성 테스트")
    @Test
    void 은행계좌_생성_테스트() {
        //given
        Account account = new Account();
        //when & then
        assertThat(Objects.isNull(account)).isFalse();
    }

    @DisplayName("은행계좌에서 잔금을 조회한다.")
    @ParameterizedTest
    @CsvSource({"1000,1000", "2000,2000", "30000000,30000000"})
    void 잔금을_조회한다(long money, long expectedResult) {
        //given
        Account account = new Account(money);

        //when
        Long deposit = account.checkDeposit();

        //then
        assertThat(deposit).isEqualTo(expectedResult);
    }

    @DisplayName("은행계좌에 예금한다.")
    @ParameterizedTest
    @CsvSource(value = {"5000:6000", "10000:11000", "5500:6500"}, delimiter = ':')
    void 예금한다(long moneyToDeposit, long expectedResult) {
        //given
        Account account = new Account(1000L);

        //when
        account.depositMoney(moneyToDeposit);

        long deposit = account.checkDeposit();

        //then
        assertThat(deposit).isEqualTo(expectedResult);
    }

    @DisplayName("은행계좌에서 출금한다")
    @ParameterizedTest
    @CsvSource(value = {"5000:5000", "8000:2000", "10000:0"}, delimiter = ':')
    void 출금한다(long moneyTowWithdrawal, long expectedResult) {
        //given
        Account account = new Account(10000L);

        //when
        account.withdrawalMoney(moneyTowWithdrawal);

        long deposit = account.checkDeposit();

        //then
        assertThat(deposit).isEqualTo(expectedResult);
    }
}