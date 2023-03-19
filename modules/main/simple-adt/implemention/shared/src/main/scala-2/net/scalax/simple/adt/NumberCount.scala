package net.scalax.simple
package adt

trait NumberCount
final class NumberCountChild[Head, Tail <: NumberCount] extends NumberCount
final class NumberCountZero                             extends NumberCount
