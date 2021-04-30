# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현해야할 기능 목록
1. 커맨드 기반 UI 기능
   * 자동차 이름 입력 받기
     - 글자수 제한도 같이 출력하면 좋을듯
   * 횟수 입력받기
     - 횟수 범위 출력하면 괜찮을듯(오버/언더플로우 방지)
   * 각 단계별 실행 결과 출력
   * 우승 결과 출력
2. 자동차 객체 관리 기능
   * 이름을 가진 자동차 객체 생성
     - 이름에 대한 검증
   * 객체의 정보 업데이트 하는 기능(경주)
3. 실제 경주를 실행하는 기능
   * 자동차별 랜덤값 생성
   * 객체 정보 업데이트 호출해서 경주 진행하는 기능
   * 경주 끝인지 체크하는 기능
