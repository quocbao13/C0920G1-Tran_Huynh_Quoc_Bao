class Ball {
    constructor(coordinateX, coordinateO, radius) {
        this.coordinateX = coordinateX;
        this.coordinateO = coordinateO;
        this.radius = radius;
    }
    getCoordinateX() {
        return this.coordinateX;
    }
    getCoordinateO() {
        return this.coordinateO;
    }
    getRadius() {
        return this.radius;
    }
    setCoordinateX(coordinateX) {
        this.coordinateX = coordinateX;
    }
    setCoordinateO(coordinateO) {
        this.coordinateO = coordinateO;
    }
    setRadius(radius) {
        this.radius = radius;
    }
}