# 🏪 자바 편의점 어플리케이션

![Java](https://img.shields.io/badge/Language-Java-blue?logo=java)
![File I/O](https://img.shields.io/badge/Storage-File%20I%2FO-green)
![Console](https://img.shields.io/badge/UI-Console-lightgrey)
![Project](https://img.shields.io/badge/Type-Console%20Application-brightgreen)

콘솔 기반의 자바 편의점 어플리케이션입니다.  
관리자와 구매자 모드로 나뉘며, 상품을 조회/등록/삭제하고 구매하거나 위시리스트에 담을 수 있습니다.  
텍스트 파일을 활용한 File I/O 기반 저장 방식을 사용했습니다.

---

## 📌 프로젝트 개요

- **프로젝트명:** 편의점 구매 & 관리 어플리케이션  
- **기간:** 2025.04.09 ~ 2025.04.11  
- **개발자:** 이수진  
- **사용 기술:**  
  - Java 기본 문법  
  - 파일 입출력(File I/O)  
  - 컬렉션 API  
  - 콘솔 기반 입력/출력 (`Scanner` 사용)

---

## 🧩 주요 기능 요약

| 모드 | 기능 |
|------|------|
| 관리자 | 상품 카테고리별 조회, 등록, 삭제 |
| 구매자 | 상품 카테고리별 조회, 구매, 위시리스트 담기/조회 |
| 공통 | 상품 이름, 가격, 개수, 카테고리(음료, 과자, 라면) 기반 처리 |
| 저장 | 파일에 상품 정보 저장/조회/삭제/수정 |

---

## 🧭 프로그램 실행 흐름도

![플로우차트](https://github.com/user-attachments/assets/4712bdc5-7eab-4633-bbfb-041ae0a0d9fb)

---

## 📦 클래스 및 메서드 요약

### 📁 model 패키지

| 클래스명 | 메서드 | 설명 |
|----------|--------|------|
| `Product` | `toString`, `toFileString`, `fromFileString` | 상품 객체, 파일 저장/불러오기 용 변환 |
| `ProductType` | (ENUM) | 음료, 과자, 라면 카테고리 분류 |
| `ProductSingleton` | `instance`, `setProductList` | 전역 상품 리스트 싱글톤 관리 |

---

### 📁 service 패키지

| 클래스명 | 메서드 | 설명 |
|----------|--------|------|
| `AdminService` | `addProduct`, `deleteProduct` | 상품 등록/삭제 |
| `CustomerService` | `buyProduct`, `addWishlist`, `myWishlist` | 상품 구매, 찜 추가/조회 |
| `FileService` | `saveProduct`, `deleteProduct`, `updateProduct`, `loadProduct` | 상품 파일 저장/수정/삭제/조회 |
| `UtilService` | `getProduct`, `categoryProductInfo` | 공통 카테고리별 필터링, 상품 목록 출력 |

---

### 📁 view 패키지

| 클래스명 | 메서드 | 설명 |
|----------|--------|------|
| `AdminView` | `adminPrintInfo()` | 관리자 모드 화면 출력 |
| `CustomerView` | `customerPrintInfo()` | 구매자 모드 화면 출력 |
| `MainView` | `menuPrintInfo`, `adminView`, `customerView` | 첫 화면 / 메뉴 선택 흐름 제어 |

---

## 💾 저장 형식 예시

상품 정보는 `data/product.txt` 파일에 저장됩니다.  

---

## 💬 느낀점

- **파일 I/O 방식의 장점과 한계**: 간단하게 데이터를 저장하고 불러올 수 있었지만, 여러 사용자가 동시에 접근하거나 상품을 수정 및 삭제할 때의 어려움도 느꼈습니다.
- **데이터베이스의 필요성 인식**: 정형화된 데이터 구조와 수정/검색의 효율성 측면에서 DB의 중요성을 이해하게 되었습니다.
- **객체 지향과 설계 패턴 학습**: 싱글톤 패턴, 계층 분리, 서비스/모델/뷰 구조 설계 등 기본적인 OOP 구조 설계에 익숙해질 수 있었습니다.

---


