package bank.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountTest {

    @DisplayName("은행계좌에서 잔금을 조회한다.")
    @Test
    void 잔금을_조회한다(){
        //given
        Long moneyToDeposit = 1000L;
        Account account = new Account(moneyToDeposit);

        //when
        Long deposit = account.checkDeposit();
        Long expectedResult = 1000L;

        //then
        Assertions.assertThat(deposit).isEqualTo(expectedResult);
    }
}