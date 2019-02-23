import React, {Component} from 'react'
import {Map, InfoWindow, Marker, GoogleApiWrapper} from 'google-maps-react';


class MapContainer extends Component {
    state = {
        showingInfoWindow: true,
        activeMarker: {},
        selectedPlace: {},
    };

    onMarkerClick = (props, marker, e) =>
        this.setState({
            selectedPlace: props,
            activeMarker: marker,
            showingInfoWindow: true
        });

    onMapClicked = (props) => {
        if (this.state.showingInfoWindow) {
            this.setState({
                showingInfoWindow: false,
                activeMarker: null
            })
        }
    };

    render() {
        return (
            <Map
                google={this.props.google}
                style={{width: '100%', height: '100%', position: 'relative'}}
                initialCenter={{
                    lat: 57.687724,
                    lng: 11.9783206
                }}
                zoom={14}
                onClick={this.onMapClicked(this.onMarkerClick)}>


                <Marker onClick={this.onMarkerClick}
                        name={'Monaden'}
                        position={{lat: 57.687724, lng: 11.9783206}}
                        info={'Computer science'}/>

                <Marker onClick={this.onMarkerClick}
                        name={'Other Marker'}
                        position={{lat: 57.7100555, lng: 11.9718498}}
                        info={'The train station'}
                />

                <Marker onClick={this.onMarkerClick}
                        name={'Other Marker'}
                        position={{lat: 57.6856745, lng: 11.9475695}}
                        info={'A Good part to be able to run through'}
                />

                <InfoWindow
                    marker={this.state.activeMarker}
                    visible={true}>
                    <div>
                        <h1>{this.state.selectedPlace.name}</h1>
                        <p>{this.state.selectedPlace.info}</p>
                    </div>
                </InfoWindow>

            </Map>
        );
    }
}

export default GoogleApiWrapper({
    apiKey: ''
})(MapContainer)