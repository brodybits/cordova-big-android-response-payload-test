// Copyright 2020-present Christopher J. Brody <chris.brody+brodybits@gmail.com>

#import <Cordova/CDVPlugin.h>

@interface BigResponsePayloadTest : CDVPlugin

- (void) test : (CDVInvokedUrlCommand *) command;

@end

@implementation BigResponsePayloadTest

- (void) test : (CDVInvokedUrlCommand *) command
{
  CDVPluginResult * result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsArray:command.arguments];;
  [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

@end
