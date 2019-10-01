moduhome3
==========

### 프론트/백엔드 공통

### 개요
이전에 스프링 프레임워크로 만든 쇼핑몰 프로젝트를 프론트엔드와 백엔드로 나누어 다시 구현하였습니다.  

**백엔드**는 스프링부트 REST API 구조로 스프링 시큐리티로 만들었으며, 상품/주문/회원과 관련된 8개의 엔티티 객체와 여러 DAO, DTO 객체로 구성되어 있습니다. 그리고 모든 리소스는 mariaDB에 저장하였습니다. 

**프론트엔드**는 react를 사용하였으며, 사용자 화면을 구현하는 과정에서 기본적인 javascript/html/css 직접 코딩했습니다.  

완성한 프로젝트는 구글 클라우드 VM인스턴스에 docker를 설치하여 가상환경을 구성하고 프론트 엔드와 백엔드 서버를 각 컨테이너에서 구동 중 입니다.

### 구현 기능
* 로그인(spring-security/JWT)
* 상품 게시판(상품 정렬/페이징/카테고리/무한 스크롤)
* 상품 상세페이지(옵션 선택/수량 변경)
* 장바구니
* 주문 페이지(주문정보 유효성 검사)
* 결제(아임포트 결제 API)

### 개발 환경
* OS: 윈도우10
* IDE: 이클립스STS, 비주얼 스튜디오 코드
* react / javascript
* springboot 2.16
* java8
* maven
* git
* mariaDB

### 배포 환경
* 구글 클라우드 VM인스턴스
* 리눅스 데비안
* docker-compose  


<br/><br/>

##  백엔드 디테일

### 사용기술
* 스프링부트 REST API
* 스프링-시큐리티
* JWT

### 엔티티 구성
* 회원
  * Users
  * Roles
* 상품
  * Goods
  * GoodsDetail
  * GoodsImages
* 주문/배송
  * Orders
  * Delivery
  * OrderItems

### 엔티티 관계도
![md3-erd](https://user-images.githubusercontent.com/33915759/65936911-1f4ef000-e459-11e9-97ea-fd93421b0daa.png)


### 서버 및 DB
* 톰캣
* 마리아DB

### 세부내용
백엔드는 리소스를 제공하는 REST API의 역할을 하며 springboot로 구현하였습니다. 또한, spring-security와 JWT를 사용하여 로그인 기능을 구현하였습니다.
