; ModuleID = 'main_source'
source_filename = "main_source"
target datalayout = "e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"

declare void @PrintString(i16*) #0

define i32 @main() #0 {
entry:
  %s = alloca [13 x i16], align 2
  store [13 x i16] [i16 72, i16 101, i16 108, i16 108, i16 111, i16 32, i16 87, i16 111, i16 114, i16 108, i16 100, i16 33, i16 0], [13 x i16]* %s, align 2
  %c = alloca i16*, align 8
  %0 = getelementptr inbounds [13 x i16], [13 x i16]* %s, i32 0, i32 0
  store i16* %0, i16** %c, align 8
  %c_value = load i16*, i16** %c, align 8
  call void @PrintString(i16* %c_value)
  %a = alloca i32, align 4
  store i32 3, i32* %a, align 4
  %lol = alloca i32, align 4
  store i32 54, i32* %lol, align 4
  %lol_value = load i32, i32* %lol, align 4
  %a_value = load i32, i32* %a, align 4
  %1 = add i32 %a_value, 5
  %2 = sub i32 %lol_value, %1
  ret i32 %2
}

attributes #0 = { "frame-pointer"="all" }
