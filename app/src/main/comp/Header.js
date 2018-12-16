import React, { Component } from 'react';
import './Header.css';

class Header extends Component {

    constructor(props) {
        super(props);
        this.state = {
          crumbs : props.crumbs
        };
    }

    render() {
        return (
            <header>
                <h1>Vinksel Corp.</h1>
                <nav id="navigationMenu">
                    
                </nav>
                <nav id="breadCrumb">
                    <ol>
                        <Crumbs crumbs={this.state.crumbs} />
                    </ol>
                </nav>
            </header>
        );
    }
}

function Crumbs(props)
{
    var crumbs = props.crumbs;
    console.log(props.crumbs);
    let htmlBuffer = [];
    crumbs.forEach(element => {
        console.log(element);
        htmlBuffer.push(<li class="crumb">{element}</li>);
    });

    return({htmlBuffer});
}

export default Header; 