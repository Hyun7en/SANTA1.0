# 🎄헬스케어 물류 관리시스템 SANTA1.0🎅
![READ ME](https://github.com/user-attachments/assets/4776107f-b8cd-4602-8227-2befa89b656c)

<br>

## 1. 프로젝트 소개

- SANTA1.0은 헬스케어 제품들의 재고와 입/출고 기본적인 기능 외 다양한 기능을 갖고 있는 창고 관리 홈페이지입니다.
- 입/출고량, 재고량 등 출고에 필요한 내용을 대시보드로 한 눈에 확인할 수 있습니다.
- 검색 기능을 통해서 원하는 정보를 편하게 조회할 수 있습니다.
- 공지사항과 게시판을 통해 ADMIN끼리 자유로운 소통이 가능합니다.

<br>

## 2. 팀원 구성
<div align="center">

| **김근영** | **고병현** | **김주일** | **김희재** | **박상협** |
| :------: |  :------: | :------: | :------: | :------: |
| [<img src="https://github.com/user-attachments/assets/c7c085f3-e32e-4f50-bcc8-c05ca28490a1" height=150 width=150> <br/> @Dubutoto](https://github.com/Dubutoto) | [<img src="https://github.com/user-attachments/assets/b8757452-f5ba-4abe-866c-cd354b6cbef6" height=150 width=150> <br/> @Hyun7en](https://github.com/Hyun7en) | [<img src="https://github.com/user-attachments/assets/f9fb0b69-b883-4ba1-904e-3a17df64dcae" height=150 width=150> <br/> @juil1-kim](https://github.com/juil1-kim) | [<img src="https://github.com/user-attachments/assets/1d9256f0-1f7f-4168-976e-874c6bcd8cc8" height=150 width=150> <br/> @HeeJava](https://github.com/HeeJava) | [<img src="https://github.com/user-attachments/assets/7ddf30e4-0fb5-45a7-a49f-edbba46356fb" height=150 width=150> <br/> @son-goten](https://github.com/son-goten) |

</div>

<br>

## 3. 개발 환경

![image](https://github.com/user-attachments/assets/9c6431bd-2212-4408-9c96-b3ce052bda89)

<br>

## 4. 브랜치 전략

![image 366](https://github.com/user-attachments/assets/351a32a9-82e5-42f5-9c83-e7be41849466)

<br>

## 5. 역할 분담

### 🍊김근영

- **UI**
    - 페이지 : 대시보드, 로그인, 회원가입
- **기능**
    - 회원가입 유효성 및 중복 검사, 이메일 검증, 계정별 접근권한 설정, 대시보드 페이지
<br>

### 👻고병현

- **UI**
    - 페이지 : 재고 관리, 주문 관리
- **기능**
    - 병현님 샬롬!

<br>

### 😎김주일

- **UI**
    - 페이지 : 배송 관리, 출고 관리, Tmap API(경로 최적화)
- **기능**
    - 배송 조회, 승인&거절, 선택된 배송 건의 경로 최적화(예상 시간, 배송 비용 확인 가능)
    - 출고 조회, 승인&거절

<br>

### 🐬김희재

- **UI**
    - 페이지 : 입고 관리, 공지사항
- **기능**
    - 입고 조회 기능(R), 공지사항 CRUD
    
<br>

### 🐼박상협

- **UI**
    - 페이지 : 게시판
- **기능**
    - 게시판 작성, 수정, 삭제, 댓글 작성
    
<br>

## 6. 개발 기간 및 작업 관리

### 개발 기간

- 전체 개발 기간 : 2025-01-10 ~ 2025-01-15
- UI 구현 : 2025-01-10 ~ 2025-01-15
- 기능 구현 : 2025-01-10 ~ 2025-01-15

<br>

### 작업 관리

- Notion과 Slack을 통해 지속적으로 작업 내용을 공유했습니다.
- 아침마다 모여 회의를 진행하며 작업 우선 순위와 To-do list 대한 고민을 나누고 Notion에 회의 내용을 기록했습니다.

<br>

## 7. 화면별 구현 기능

### [초기화면]
- 로그인 처음 화면입니다.
- 회원가입, 비밀번호 찾기 기능이 습니다.

###
| 초기화면 |
|----------|
|![join](https://github.com/user-attachments/assets/d312b5d5-a264-41ec-99ed-6942b916c29f)|

<br>

### [회원가입]
- 아이디를 입력하고 CHECK 버튼 누를 시 유효성 검사가 진행되고 통과하지 못한 경우 각 경고 문구가 입력창 하단에 표시됩니다.
- 이메일 주소의 형식이 유효하지 않거나 이미 가입된 이메일일 경우 경고 문구가 입력창 하단에 표시됩니다.
- 직원 코드 입력시 정해진 ROOT 권한 코드가 아닐 경우 ADMIN 권한으로 가입됩니다.

| 회원가입 |
|----------|
|![join](https://github.com/user-attachments/assets/88f98881-4367-42b7-9e8f-ff14e6ad0ea5)|

<br>

### [아이디 찾기/비밀번호 초기화]
- 아이디를 찾고 싶은 경우 회원가입 할 때 기입한 이메일을 입력하면 해당 이메일에 아이디를 보내줍니다.
- 비밀번호를 잃어버린 경우 회원가입 할 때 기입한 이메일을 입력하면 해당 이메일에 패스워드 초기화하는 링크를 주고 링크를 들어가면 새로운 비밀번호를 입력하게 합니다.

| 아이디 찾기/비밀번호 초기화 |
|----------|
|![join](https://github.com/user-attachments/assets/ef9104f1-6acf-468b-9c92-3e2e6d528669)|

<br>

### [대시보드]
- 연간 입고/출고/재고량을 한 눈에 파악할 수 있습니다.
- 월별 입고/출고/재고량과 창고별, 카테고리별, 주문량을 파악할 수 있습니다.

| 대시보드 |
|----------|
|<img width="1708" alt="스크린샷 2025-01-16 14 50 20" src="https://github.com/user-attachments/assets/5271481b-9592-48dc-8f9d-2a595b86af7c" />|
|<img width="1708" alt="스크린샷 2025-01-16 14 50 43" src="https://github.com/user-attachments/assets/bd50c450-ae37-49e4-b7c2-80ef10a45a61" />|


<br>

### [재고 관리]
- 창고별, 품목별로 재고 조회 가능합니다.
- 전체 페이지 조회 또는 컬럼별로 검색 가능합니다.

| 재고 관리 |
|----------|
|![join](https://github.com/user-attachments/assets/e243e0dd-6aeb-49a4-aa9f-b8264afa4b0f)|
|![join](https://github.com/user-attachments/assets/c61ff54f-a52b-4af5-8623-e4687dd77b1a)|

<br>

### [입/출고 관리]
- 입/출고 내역을 전체 조회 가능합니다.
- 주문 승인을 하면 출고 승인 목록에 등록됩니다
- 출고 승인 목록에서 출고 승인, 거절 버튼을 누르면 승인 거절 할 수 있으며 승인할 경우 배송 승인 목록에 등록됩니다.

| 입/출고 관리 |
|----------|
|![join](https://github.com/user-attachments/assets/c27c73a4-1924-4872-8daf-c3df6e322dca)|
|![join](https://github.com/user-attachments/assets/84d7cabe-e6b4-42ea-afd5-69d541521135)|
|![join](https://github.com/user-attachments/assets/e323416f-1192-4e98-b43e-471ed7b69db9)|

<br>

### [주문 관리]
- 일자, 상품명, 지점, 주문 상태, 전체 조회 가능합니다.
- 주문 승인, 거절이 가능하며 창고에 적재되어 있는 재고수량이 주문수량보다 적으면 승인이 거절됩니다.

| 주문 관리 |
|----------|
|![join](https://github.com/user-attachments/assets/63ed07da-db35-4c78-a445-1cfac131492f)|
|![join](https://github.com/user-attachments/assets/83ab9f59-7df1-491a-8700-f170b96da2f7)|
|![join](https://github.com/user-attachments/assets/4997935c-d623-4802-958c-f596ec03e351)|


<br>

### [배송 관리]
- 배송 내역 전체 조회 가능합니다.
- 배송 승인, 거절이 가능하며 배송을 승인할 경우 스케줄러 기능을 사용하여 오전 10시에 모든 물건을 각 지점에 배송합니다.
- 모든 지점에 대해 경로 최적화 Tmap API를 사용하여 예상 배송 완료시간, 거리, 비용이 확인 가능합니다.

| 배송 관리 |
|----------|
|![join](https://github.com/user-attachments/assets/65257e84-8bd3-42fd-9ef1-4254e417a8aa)|
|![join](https://github.com/user-attachments/assets/123f1046-a1db-4b3c-a6d1-05c21f53824b)|
|![join](https://github.com/user-attachments/assets/0341a630-69c1-4d33-a50a-94041d904466)|

<br>

### [공지사항]
- 공지사항 전체 조회 가능합니다.
- 공지사항 수정 시 이전에 입력한 값들을 가져와서 표시합니다.
- 수정, 삭제 버튼 클릭시 alert 메시지로 한번 더 확인합니다.

| 공지사항 |
|----------|
|![join](https://github.com/user-attachments/assets/ef421282-52a5-468a-9c14-d1869c02b085)|
|![join](https://github.com/user-attachments/assets/5f1b4397-a1da-47ab-90a9-8739c9af8dce)|
|![join](https://github.com/user-attachments/assets/6bc9c9e8-8601-4195-a206-0bb8271597f0)|
|![join](https://github.com/user-attachments/assets/dcf0f4f1-5227-4dd2-8b75-5b04a6ffb483)|

<br>

### [자유게시판]

| 자유게시판 |
|----------|

<br>

### [직원 관리]
- root는 창고의 모든 관리자 명단 조회 가능합니다.
- 관리자 정보를 수정 또는 삭제할 수 있습니다.

| 직원 관리 |
|----------|
|![join](https://github.com/user-attachments/assets/01758484-55e8-4473-977a-347377ceffc2)|
|![join](https://github.com/user-attachments/assets/7b154aac-d8c5-4b24-ad1d-e3a95204a9fd)|










