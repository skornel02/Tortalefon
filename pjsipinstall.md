# A write-up on how to (not) install pjsip succesfully on a wide range of devices 

Our aim is to get a library that is usable by our java application through the JNI

But if you use a standard platform we have precompiled libraries (x86-64 for linux and windows)

## Linux:

### Get the dependencies
```
apt-get install libasound2-dev libssl-dev libv4l-dev libsdl2-dev libsdl2-gfx-dev libsdl2-image-dev libsdl2-mixer-dev libsdl2-net-dev libsdl2-ttf-dev libx264-dev libavformat-dev libavcodec-dev libavdevice-dev libavfilter-dev libavresample-dev libavutil-dev libavcodec-extra libopus-dev libopencore-amrwb-dev libopencore-amrnb-dev libvo-amrwbenc-dev make gcc g++ swigger
```

### Download
Get to the directory you wish to work in, then download and extract the latest version of pjsip

```
cd /path/to/
wget https://www.pjsip.org/release/2.8/pjproject-2.8.tar.bz2
tar -xjf pjproject-2.8.tar.bz2
cd pjproject-2.8.tar.bz2
```

### Configure
Configure the project with the appropriate configuration


For a raspberry pi zero W
```
./configure --disable-sdl --disable-ffmpeg --disable-v412 --disable-openh264 --disable-libwebrtc
```

For a normal pc running on the x86-64 platform
```
./configure --enable-shared
```


### Building pjsip

This is just a waiting game, if you build on a somewhat decent processor this is a 5 minute task, if you compile on the raspberry pi zero w this is a 4 hour long task...

```
make dep
make
sudo make install
```

### Build pjsua-swig

```
cd pjsip-apps/src/swig
make
```

### Using the library
you can find the libpjsua2.so hidden in the java folder and move it to a path that is in the java path.

```
cd java/output
mv libpjsua2.so /java/path
```

## Windows

I've done it once... it's a mess i promise... use crosscompile
...to be continued from here...
