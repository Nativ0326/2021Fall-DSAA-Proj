package nBodyFromGithub;

class Perspective {
    public float zoomFactor;
    private float xeye;
    private float yeye;
    private float zeye;
    private float xat;
    private float yat;
    private float zat;

    public Perspective() {
    }

    public Perspective(float xeye, float yeye, float zeye, float xat, float yat, float zat, float zoomFactor) {
        this.xeye = xeye;
        this.yeye = yeye;
        this.zeye = zeye;
        this.xat = xat;
        this.yat = yat;
        this.zat = zat;
        this.zoomFactor = zoomFactor;
    }

    public float getXat() {return xat;}
    public float getYat() {return yat;}
    public float getZat() {return zat;}
    public float getXeye() {return xeye;}
    public float getYeye() {return yeye;}
    public float getZeye() {return zeye;}
    public void setXat(float xat) {this.xat = xat;}
    public void setYat(float yat) {this.yat = yat;}
    public void setZat(float zat) {this.zat = zat;}
    public void setXeye(float xeye) {this.xeye = xeye;}
    public void setYeye(float yeye) {this.yeye = yeye;}
    public void setZeye(float zeye) {this.zeye = zeye;}

    public float getZoomFactor() {
        return zoomFactor;
    }

    public void setZoomFactor(float zoomFactor) {
        this.zoomFactor = zoomFactor;
    }

    public float getRadius() {
        return (float) Math.sqrt(xeye * xeye + yeye * yeye + zeye * zeye);
    }

    public void setRadius(float radius) {
        final float theta = getTheta();
        final float phi = getPhi();
        xeye = radius * ((float) Math.cos(phi)) * ((float) Math.sin(theta));
        yeye = radius * ((float) Math.sin(theta)) * ((float) Math.sin(phi));
        zeye = radius * ((float) Math.cos(theta));
    }

    public float getTheta() {
        if (getRadius() == 0f)
            return 0f;
        return (float) Math.acos(zeye / getRadius());
    }

    public void setTheta(float theta) {
        final float radius = getRadius();
        final float phi = getPhi();
        xeye = radius * ((float) Math.cos(phi)) * ((float) Math.sin(theta));
        yeye = radius * ((float) Math.sin(theta)) * ((float) Math.sin(phi));
        zeye = radius * ((float) Math.cos(theta));
    }

    public float getPhi() {
        if (xeye == 0f)
            return 0f;
        return (float) Math.atan(yeye / xeye);
    }

    public void setPhi(float phi) {
        final float radius = getRadius();
        final float theta = getTheta();
        xeye = radius * ((float) Math.cos(phi)) * ((float) Math.sin(theta));
        yeye = radius * ((float) Math.sin(theta)) * ((float) Math.sin(phi));
        zeye = radius * ((float) Math.cos(theta));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Perspective{" +
                "  xeye=" + xeye +
                ", yeye=" + yeye +
                ", zeye=" + zeye +
                "  radius=" + getRadius() +
                ", theta=" + getTheta() +
                ", phi=" + getPhi() +
                ", xat=" + xat +
                ", yat=" + yat +
                ", zat=" + zat +
                ", zoomFactor=" + zoomFactor +
                '}';
    }
}
