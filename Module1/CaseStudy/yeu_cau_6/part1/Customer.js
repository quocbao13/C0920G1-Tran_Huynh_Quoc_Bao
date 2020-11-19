class Customer {
    constructor(name, cmnd, birthday, email, address, typeCustomer, discount, quantityIncluded, typeRoom, rentDay, typeService, ) {
        this.name = name;
        this.cmnd = cmnd;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.typeCustomer = typeCustomer;
        this.discount = discount;
        this.quantityIncluded = quantityIncluded;
        this.typeRoom = typeRoom;
        this.rentDay = rentDay;
        this.typeService = typeService;
    }
    getName(){
        return this.name;
    }
    getCmnd(){
        return this.cmnd;
    }
    getBirthday(){
        return this.birthday;
    }
    getEmail(){
        return this.email;
    }
    getAddress(){
        return this.address;
    }
    getTypeCustomer(){
        return this.typeCustomer;
    }
    getDiscount() {
        return this.discount;
    }
    getQuantityIncluded() {
        return this.quantityIncluded;
    }
    getTypeRoom() {
        return this.typeRoom;
    }
    getRentDay() {
        return this.rentDay;
    }
    getTypeService() {
        return this.typeService;
    }
    setName(name){
        this.name = name;
    }
    setCmnd(cmnd){
        this.cmnd = cmnd;
    }
    setBirthday(birthday){
        this.birthday = birthday;
    }
    setEmail(email){
        this.email = email;
    }
    setAddress(address){
        return this.address = address;
    }
    setTypeCustomer(typeCustomer){
        this.typeCustomer = typeCustomer;
    }
    setDiscount(discount) {
        this.discount = discount;
    }
    setQuantityIncluded(quantityIncluded) {
        this.quantityIncluded = quantityIncluded;
    }
    setTypeRoom(typeRoom) {
        this.typeRoom = typeRoom;
    }
    setRentDay(rentDay) {
        this.rentDay = rentDay;
    }
    setTypeService(typeService) {
        this.typeService = typeService;
    }
    totalPays(){
        let money = 0;
        if (this.typeService === "Villa"){
            money = 500;
        }else if (this.typeService === "House"){
            money = 300;
        }else if (this.typeService === "Room"){
            money = 200;
        }
        return this.rentDay * money * (1 - this.discount/100);

    }
}