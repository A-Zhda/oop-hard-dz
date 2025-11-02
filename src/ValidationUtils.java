
public class ValidationUtils {

    private static final int NAME_LENGHT = 5;

    public static boolean notBlank(String value){
        if (value == null) {
            return false;
        }
        return !value.trim().isEmpty();
    }

    public static boolean positive(long value){
        return value > 0;
    }

    public static boolean requireBefore(long start,long end){
        return start > end;
    }

    public static void isValidEmail(String email){
        if (!notBlank(email)){
            throw new InvalidEmailException("ВЫ внесли некорректный имэйл");
        }
        if (!email.contains("@")){
            throw new InvalidEmailException("ВЫ внесли некорректный имэйл");
        }
    }

    public static void isValidName(String name){
        if (!notBlank(name) || name.length() < NAME_LENGHT){
            throw new InvalidNameException("ВЫ внесли некорректное имя");
        }
    }

    public static void isValidDate(long date){
        if (requireBefore(date, System.currentTimeMillis())){
            throw new InvalidDateException("ВЫ внесли некорректную дату");
        }
    }

    public static void isValidPromo(String promo){
        if (!notBlank(promo) || promo.length() < 5){
            throw new InvalidPromoException("ВЫ внесли некорректный промокод");
        }
    }

    public static void isValidDate(long dateStart,long dateEnd){
        if (requireBefore(dateStart, dateEnd)){
            throw new InvalidDateException("ВЫ внесли некорректную дату");
        }
    }

    public static void isValidSlot(Slot slot){
        if (slot == null || slot.getStatus() == SlotStatus.BOOKED ){
            throw new InvalidSlotStatusException("Слот занят");
        }
    }


}
