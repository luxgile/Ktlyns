; ModuleID = 'main_source'
source_filename = "main_source"
target datalayout = "e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"

declare void @PrintMark() #0

declare void @PrintChar(i16) #0

declare void @PrintString(i16*) #0

define i32 @main() #0 {
entry:
  %s = alloca [13 x i16], align 2
  store [13 x i16] [i16 72, i16 101, i16 108, i16 108, i16 111, i16 32, i16 87, i16 111, i16 114, i16 108, i16 100, i16 33, i16 0], [13 x i16]* %s, align 2
  ret i32 0
}

attributes #0 = { "frame-pointer"="all" }
