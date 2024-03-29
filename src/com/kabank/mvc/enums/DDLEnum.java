package com.kabank.mvc.enums;

public enum DDLEnum {
	CREATE_TABLE_MEMBER{
		@Override
		public String toString() {
			return "CREATE TABLE Member("
					+"id VARCHAR2(20) PRIMARY KEY,"
					+"pass VARCHAR2(20),"
					+"name VARCHAR2(20),"
					+"ssn VARCHAR2(20),"
					+"phone VARCHAR2(20),"
					+"email VARCHAR2(20),"
					+"profile VARCHAR2(20) default 0,"
					+"addr VARCHAR2(20)"
						+")";
		}
	},
	CREATE_TABLE_ATTEND{
		@Override
		public String toString() {
			return "CREATE TABLE Attend("
					+"seq NUMBER VARCHAR2(20) PRIMARY KEY,"
					+"week VARCHAR2(10),"
					+"status VARCHAR2(10)"
					+"id VARCHAR2(10)"
					+")";
		}
	},
	CREATE_TABLE_BANK{
		@Override
		public String toString() {
			return "CREATE TABLE Bank("
					+"customer_num number PRIMARY KEY,"
					+"account_num VARCHAR2(20),"
					+"money VARCHAR2(20) default 0,"
					+"id VARCHAR2(20),"
					+"FOREIGN KEY(id) REFERENCES Member(id) ON DELETE CASCADE"
					+ ")";
		}
	},
	CREATE_TABLE_SKT{
        @Override
        public String toString() {
            return "CREATE TABLE Phone("
                    +"customers_num number primary key,"
                    +"phone_num varchar2(20) not null,"
                    +"regdate date default sysdate,"
                    +"id varchar2(20),"
                    +"foreign key (id) references Member(id) on delete cascade"
                    +")";
        }
	}
}
