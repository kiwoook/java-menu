## 기능 구현

### 코치 이름들을 입력하는 기능

- 각 이름은 2~4 글자 사이여야 한다.
- , 로 구분한다.
  - 코치의 인원 수는 2~5명이여야 한다.

### 코치들이 못 먹는 음식 입력하는 기능

- 먹지 못하는 메뉴들을 입력한다.
- ,로 구분한다.
- 공백을 입력하면 먹지 못하는 메뉴가 없다.
- 최대 2개까지 허용한다.

### 요일 별로 정하는 기능

- 요일 순으로 카테고리를 정한 후 각 크루원들에 메뉴를 정한다.

### 요일에 카테고리를 정하는 기능

- 카테고리를 랜덤으로 뽑아서 정한다.
- 각 카테고리는 1~5 사이의 숫자로 하여야 한다.
- 해당 카테고리가 이미 2번 이상 사용되었다면 다시 뽑는다.

### 각 크루원의 메뉴를 정하는 기능

- 메뉴의 선택은 shuffle한 후에 첫 번째 값을 사용하도록 한다.
- 요일 순으로 각 크루원들의 메뉴를 정해준다.
- 한 주 간의 메뉴는 중복되지 않으며 먹지 못하는 음식은 넣지 않는다.
  - 메뉴가 중복된다면 다시 shuffle하여 첫 번째 값을 사용한다.
- 다른 크루원과 메뉴가 중복을 허용한다.
- 메뉴는 정해진 카테고리 범주 내에서 정해져야 한다.

### 결과를 출력하는 기능

- 요일, 카테고리, 크루원 순으로 출력한다.
- 크루원은 입력한 순으로 출력된다.
- 대괄호로 정리하며 |를 사용하여 구분을 한다.