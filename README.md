# java-racingcar-precourse
### 기능 요구 사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
8. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 기능 구현
- **Controller**<br>
  RacingcarController: 메인에서 호출됨 
    <br>- InputView()로 사용자 입력을 받아 Service에 전달
    <br>- Service에서 처리된 결과를 받아 OutputView()를 사용해 출력
    <br><br>
- **Domain** <br>
  도메인 규칙은 해당 객체 내부에 작성해, 외부에서 수정하거나 조작하지 못하도록 캡슐화함
<br>- Car: 각 자동차의 상태와 행동을 책임지며, 이름과 현재 위치를 가짐
<br>- Cars: 파싱된 리스트로 Car 객체의 집합을 생성하고 관리함. 전체 자동차 중 가장 멀리 이동한 차를 구하고 목록을 반환함
<br><br>
- **Service**<br>
  RacingcarService: 메인 비즈니스 로직으로 흐름만 조율함<br>
  - **Util**<br>
        - NameParser: 각 자동차 이름 문자열을 구분자로 분리한 후, 공백 제거 및 소문자 변환  <br>
        - RandomNumberGenerator: 0~9 사이 무작위 값 생성<br>
  - **Validator (Service 전용 검증 로직)**<br>
        - InputValidator: 자동차 이름이 5자 이하인지, 중복이 없는지, 빈 문자열이 아닌지, 입력 횟수가 1 이상인지
              <br><br>
- **View**
<br>IOView -> Input(), Output() 메서드로 책임 분리
  <br>- Input(): 경주할 자동차와 시도 횟수 받기
<br>-  Output(): 실행 결과 및 최종 우승자 출력
<br><br>
- Exception (IllegalArgumentException 발생)
  <br>ErrorMessage: ENUM 구현
  <br>  - UNSUPPORTED_DELIMITER: 구분자가 쉼표(,)가 아닐 경우
  <br>  - INVALID_NAME_LENGTH: 자동차 이름이 5자를 초과할 경우
  <br>  - DUPLICATED_NAME: 자동차 이름이 중복일 경우
  <br>  - EMPTY_NAME: 빈 문자열이 입력된 경우
  <br> - INVALID_COUNT: 시도 횟수가 0 또는 음수일 경우 (long)

### 테스트 항목
- RacingcarServiceTest
- InputValidator (파싱 또는 입력된 값이 도메인 규칙에 맞는지 검증)
  - "pobi", "woni" -> 성공
  - "Po_bi", "won1" -> 알파벳 외 문자 포함 에러
  - "", "woni" -> 공백 문자열 에러
  - "sandra" -> 5자 초과 에러
  - "pobi", "pobi" -> 중복 이름 에러
  - 시도 횟수 0 or 음수-> 에러
- NameParser
  - "Pobi, Woni" -> ["pobi", "woni"] : 소문자 변환 및 공백 제거 확인
  - "pobi:woni" -> 에러
  - null 값 -> 에러
  - "" -> 에러
- RandomNumberGenerator
- CarTest
  - 랜덤값 ≥ 4 -> 차 위치 + 1
  - 랜덤값 < 4 -> 정지
- CarsTest
  - 입력 값들로 Cars를 생성하면 Car 객체가 정확히 만들어지는가?  
  - 각 Car 객체의 최댓값 위치를 잘 반환하는가
  - 단독 우승 판단 -> getWinners() = ["pobi"]
  - 공동 우승 판단 -> getWinners() = ["pobi", "woni"]
  - 랜덤값이 모두 4 미만인 경우 (모든 자동차 위치 = 0) -> 빈 리스트 반환