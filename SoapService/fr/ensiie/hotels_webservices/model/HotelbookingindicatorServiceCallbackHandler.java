
/**
 * HotelbookingindicatorServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package fr.ensiie.hotels_webservices.model;

    /**
     *  HotelbookingindicatorServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HotelbookingindicatorServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HotelbookingindicatorServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HotelbookingindicatorServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getUser method
            * override this method for handling normal response from getUser operation
            */
           public void receiveResultgetUser(
                    fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.GetUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUser operation
           */
            public void receiveErrorgetUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMyReservation method
            * override this method for handling normal response from getMyReservation operation
            */
           public void receiveResultgetMyReservation(
                    fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.GetMyReservationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMyReservation operation
           */
            public void receiveErrorgetMyReservation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for postReservation method
            * override this method for handling normal response from postReservation operation
            */
           public void receiveResultpostReservation(
                    fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.PostReservationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postReservation operation
           */
            public void receiveErrorpostReservation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHotel method
            * override this method for handling normal response from getHotel operation
            */
           public void receiveResultgetHotel(
                    fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.GetHotelResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHotel operation
           */
            public void receiveErrorgetHotel(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelReservation method
            * override this method for handling normal response from cancelReservation operation
            */
           public void receiveResultcancelReservation(
                    fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.CancelReservationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelReservation operation
           */
            public void receiveErrorcancelReservation(java.lang.Exception e) {
            }
                


    }
    