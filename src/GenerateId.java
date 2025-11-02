public class GenerateId {
    private static long numberOfId= 1000;

    public static long generateId(){
        return numberOfId++;
    }
}
