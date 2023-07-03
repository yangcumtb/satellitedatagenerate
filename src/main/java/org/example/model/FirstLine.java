package org.example.model;

/**
 * 数据第一行
 */
public class FirstLine {

    public String satelliteoribitName;

    //轨道报行号
    public String lineNum;

    //卫星号
    public String satelliteNum;

    //卫星分类
    public String satelliteType;

    //国际登记号10-11
    public String yearLast2;

    //国际登记号12-14
    public String serialNum;
    //国际登记号15-17
    public String launchCount;

    //轨道预报的历元年，后两位19-20
    public String firtCalendarLast2;

    //轨道预报的历元时刻21-32
    public String firtCalendarTime;

    //平均运动第一次漂移
    public String firstDrift;

    //平均运动第二次漂移
    public String secnondDrift;

    //BSTAR拖调制系数
    public String bstar;

    //星历类型；
    public String calendarType;

    //元素数目
    public String elementCount;

    //校验码
    public String checksum;

    /**
     * 构造函数，根据序列号来随机初始化
     *
     * @param serialNum 序列号
     */
    public FirstLine(Integer serialNum) {
        this.satelliteoribitName = "ISS (ZARYA)-" + serialNum;
        this.lineNum = "1";
        this.satelliteNum = String.valueOf(25544 + serialNum);
        this.satelliteType = "U";
        this.yearLast2 = "98";
        this.serialNum = "067";
        this.launchCount = "A  ";
        this.firtCalendarLast2 = "23";
        this.firtCalendarTime = "173.82006554";
        this.firstDrift = " .00016543";
        this.secnondDrift = " 00000+0";
        this.bstar = " 29418-3";
        this.calendarType = "0";
        this.elementCount = " 999";
        this.checksum = "1";
    }

    /**
     * 转字符方法重载
     *
     * @return
     */
    @Override
    public String toString() {
        return lineNum + " " + satelliteNum + satelliteType + " " + "98067A   23173.82006554  .00016543  00000+0  29418-3 0  9991";
    }
}
