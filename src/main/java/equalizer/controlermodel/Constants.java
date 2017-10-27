package equalizer.controlermodel;

public final class Constants {
	
	public static enum ErrorCode {
		UNKNOWN,
		ACTIVITY_SERVICES,
		PAYMENTS_SERVICES,
		PERSON_SERVICES,
		TASKS_SERVICES
	}
	
	public static String errorCodeName (ErrorCode code) {
		
		String codeName = "";
		switch (code) {
		case ACTIVITY_SERVICES:
			codeName = "ACTIVITY_SERVICES";
			break;
		case PAYMENTS_SERVICES:
			codeName = "PAYMENTS_SERVICES";
			break;
		case PERSON_SERVICES:
			codeName = "PERSON_SERVICES";
			break;
		case TASKS_SERVICES:
			codeName = "TASKS_SERVICES";
			break;
		default:
			codeName = "UNKNOWN";
		}
		return codeName;
	}
	
	public static enum ErrorType {
		UNKNOWN,
	    ACTIVITY_NOT_FOUND,
	    PAYMENT_NOT_FOUND,
		PERSON_NOT_FOUND,
		TASK_NOT_FOUND,
		ACTIVITYOWNER_MISSMATCH,
		PAYMENTSLISTS_MISSMATCH
	}
	
	public static String errorTypeName (ErrorType type) {
		
		String typeName = "";
		switch (type) {
		case ACTIVITY_NOT_FOUND:
			typeName = "ACTIVITY_NOT_FOUND";
			break;
		case PAYMENT_NOT_FOUND:
			typeName = "PAYMENT_NOT_FOUND";
			break;
		case PERSON_NOT_FOUND:
			typeName = "PERSON_NOT_FOUND";
			break;
		case TASK_NOT_FOUND:
			typeName = "TASK_NOT_FOUND";
			break;
		case ACTIVITYOWNER_MISSMATCH:
			typeName = "ACTIVITYOWNER_MISSMATCH";
			break;
		case PAYMENTSLISTS_MISSMATCH:
			typeName = "PAYMENTSLISTS_MISSMATCH";
			break;
		default:
			typeName = "UNKNOWN";
		}
		return typeName;
	}
	
	public static enum PaymentStatus {
		PENDING,
		REQUESTED,
		PAID,
		CONFLICT
	}
	
	public static String paymentStatusName (PaymentStatus status) {
		
		String statusName = "";
		switch (status) {
		case PENDING:
			statusName = "PENDING";
			break;
		case REQUESTED:
			statusName = "REQUESTED";
			break;
		case PAID:
			statusName = "PAID";
			break;
		case CONFLICT:
			statusName = "CONFLICT";
			break;
		default:
			statusName = "UNKNOWN";
		}
		return statusName;
	}
}