package com.kabank.mvc.enums;

public enum DMLEnum {
	WHERE,AND,
	COUNT{
@Override
		public String toString() {
			return "SELECT COUNT(*) AS count FROM ";
		}
	},
	SELECT{
@Override
		public String toString() {
			return "SELECT FROM ";
		}
	},
	INSERT{
		@Override
		public String toString() {
			return "INSERT INTO ";
		}
	},
	SPACE{
		@Override
		public String toString() {
			return " '%s' ";
		}
	},
	EQUAL{
		@Override
		public String toString() {
			return " = ";
		}
	},
	VALUES{
		@Override
		public String toString() {
			return " ) VALUES ( ";
		}
	},
	PARENTHESES{
		@Override
		public String toString() {
			return " ( ";
		}	
	},
	PARENTHESESCLOSE{
		@Override
		public String toString() {
			return " )";
		}
	},
	FULLSTOP{
		@Override
		public String toString() {
			return ",";
		}
	},
	UPDATE_PASSWORD{
		@Override
		public String toString() {
			return "UPDATE Member SET pass = '@' WHERE id='$'";
		}
	},
	DELETE_MEMBER{
		@Override
		public String toString() {
			return "DELETE FROM Member WHERE id = '@'";
		}
	},
	ACCOUNT_NUMBER{
		@Override
		public String toString() {
			return "INSERT INTO Bank ( accountNum,customNum,id,money ) VALUES ( '%s','%d','%s','%s' )";
		}
	}
}

